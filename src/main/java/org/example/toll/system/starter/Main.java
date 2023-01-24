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
import org.example.vehicle.register.plugin.VehicleRegisterPlugin;

public class Main {
    static VehicleRegisterPersistenceStorage fileStorage = new VehicleRegisterFileStorage();
    static TollSystempersistenceStorage tollSystempersistenceStorage = new TollSystemSqlitePersistenceStorage();
    static TollSystemPresenterImpl tollSystemPresenter = new TollSystemPresenterImpl();
    static VehicleRegisterPlugin vehicleRegisterPlugin = new VehicleRegisterPlugin();
    static TollSystemApp tollSystemApp = new TollSystemApp(tollSystempersistenceStorage, tollSystemPresenter, vehicleRegisterPlugin);
    static VehicleRegister vehicleRegisterApp = new VehicleRegister(vehicleRegisterPlugin, fileStorage);
    static TollSystemController tollSystemController = new TollSystemController(tollSystemApp);
    static TollSystemView tollSystemView = new TollSystemView(tollSystemController);


    public static void main(String[] args) {
        tollSystemPresenter.setTollSystemView(tollSystemView);
        vehicleRegisterPlugin.setVehicleRegister(vehicleRegisterApp);
        tollSystemView.run();
    }
}