package controller;

import Main.CustomerSatu;
import Model.Customer.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class controllerCustomer {
     CustomerSatu frame;
     List<ModelCustomer> pl;
     InterfaceDAOCustomer impcustomer;
    
    
   public controllerCustomer(CustomerSatu frame){
    this.frame = frame;
    impcustomer = new DAOCustomer();
    pl = impcustomer.getAll();
    }
    public void isitabel (){
        pl = impcustomer.getAll();
        ModelTabelCustomer mm = new ModelTabelCustomer(pl);
        frame.getTabelpaket().setModel(mm);
    }



   

    private class CustomerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.showCustomerPanel(makananList, minumanList);
        }
    }

    private class AdminButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.showLoginPanel();
        }
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = mainView.getLoginPanel().getUsername();
            String password = mainView.getLoginPanel().getPassword();

            if (admin.authenticate(username, password)) {
                mainView.showAdminPanel();
            } else {
                JOptionPane.showMessageDialog(mainView, "Username atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    

    private class EditMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.showMenuPanel(makananList, minumanList);
        }
    }

    private class ViewHistoryButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<History> historyList = new ArrayList<>();

            try (Connection conn = Database.connect()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM riwayat_pemesanan");

                while (rs.next()) {
                    historyList.add(new History(rs.getString("customer_name"), rs.getDouble("total_price")));
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            mainView.showHistoryPanel(historyList);
        }
    }
}