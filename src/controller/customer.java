package controller;

import Main.CustomerSatu;

import Model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Hewan.*;
import Model.Customer.*;
import Model.Pegawai.*;
import Model.riwayat.Modelriwayat;

public class customer {
    private MainView mainView;
    private List<MenuItem> makananList;
    private Admin admin;
    
    List<ModelCustomer> daftarmakanan;
    CustomerSatu frame;
    InterfaceDAOMakanan makanan;
    
   public customer(CustomerSatu frame){
    this.frame = frame;
    makanan = new DAOMakanan();
    daftarmakanan = makanan.getAll();
    }
    public void isitabel (){
        daftarmakanan = makanan.getAll();
        modeltabelcustomer mm = new modeltabelcustomer(daftarmakanan);
        frame.getTabelmakanan().setModel(mm);
    }

    public customer(MainView mainView) {
        this.mainView = mainView;
        this.makananList = new ArrayList<>();
        this.admin = new Admin("admin", "password");
        loadMenuItems();

        mainView.setCustomerPanel(new CustomerPanel());
        mainView.setAdminPanel(new AdminPanel());
        mainView.setOrderPanel(new OrderPanel());
        mainView.setLoginPanel(new LoginPanel());
        mainView.setHistoryPanel(new HistoryPanel());

        mainView.showMainMenu();
        mainView.addCustomerButtonListener(new CustomerButtonListener());
        mainView.addAdminButtonListener(new AdminButtonListener());
        mainView.addLoginButtonListener(new LoginButtonListener());
        
        mainView.addEditMenuButtonListener(new EditMenuButtonListener());
        mainView.addViewHistoryButtonListener(new ViewHistoryButtonListener());
    }

    private void loadMenuItems() {
        try (Connection conn = Database.connect()) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM makanan");
            while (rs.next()) {
                makananList.add(new MenuItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }

            rs = stmt.executeQuery("SELECT * FROM minuman");
            while (rs.next()) {
                minumanList.add(new MenuItem(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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