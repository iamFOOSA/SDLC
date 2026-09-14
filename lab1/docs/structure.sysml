package CurrencyConverter {
    part def CurrencyModel;
    part def MainView;
    part def InputDialog;
    part def CurrencyController;

    part application {
        part model : CurrencyModel;
        part view : MainView;
        part dialog : InputDialog;
        part controller : CurrencyController;

        connect view to controller;
        connect controller to model;
        connect controller to dialog;
        connect model to view;
    }
}
