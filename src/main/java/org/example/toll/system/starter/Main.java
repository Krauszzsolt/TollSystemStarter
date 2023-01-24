package org.example.toll.system.starter;

import org.example.app.VehicleRegister;
import org.example.app.interfaces.VehicleRegisterPersistenceStorage;
import org.example.storage.VehicleRegisterFileStorage;
import org.example.toll.system.app.TollSystemApp;
import org.example.toll.system.app.storage.TollSystempersistenceStorage;
import org.example.toll.system.consol.ui.TollSystemController;
import org.example.toll.system.consol.ui.TollSystemPresenterImpl;
import org.example.toll.system.consol.ui.TollSystemView;
import org.example.toll.system.persistence.storage.TollSystemSqlitePersistenceStorage;

public class Main {
    static VehicleRegisterPersistenceStorage fileStorage = new VehicleRegisterFileStorage();
    static TollSystempersistenceStorage tollSystempersistenceStorage = new TollSystemSqlitePersistenceStorage();
    static TollSystemPresenterImpl tollSystemPresenter = new TollSystemPresenterImpl();
    static TollSystemApp tollSystemApp = new TollSystemApp(tollSystempersistenceStorage, tollSystemPresenter);
    static VehicleRegister vehicleRegister = new VehicleRegister(tollSystemApp, fileStorage);
    static TollSystemController tollSystemController = new TollSystemController(tollSystemApp);
    static TollSystemView tollSystemView = new TollSystemView(tollSystemController);


    public static void main(String[] args) {
        tollSystemPresenter.setTollSystemView(tollSystemView);
        tollSystemApp.setVehicleRegister(vehicleRegister);
        tollSystemView.run();
    }
}