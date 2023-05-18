public class Job {

    private Parcel receiver;
    private Vehicle driver;
    private String ShipmentDate;

    public Job(Parcel rc, Vehicle dr, String Shipdate){
        receiver = rc;
        driver = dr;
        ShipmentDate = Shipdate;
    }

    public String getDriverName(){
        return driver.getDriverName();
    }

    public String getDriverEmail(){
        return driver.getDriverEmail();
    }

    public String getDriverContact(){
        return driver.getDriverContact();
    }

    public String getDriverGender(){
        return driver.getDriverGender();
    }

    public String getDriverLicense(){
        return driver.getDriverLicense();
    }

    public String getVehicle(){
        return driver.getType() + "(" + driver.getModel() + ")";
    }
    public String getPlate(){
        return driver.getPlate();
    }
    public String getShippingDate(){
        return ShipmentDate;
    }

    public String getReceiverName(){
        return receiver.getReceiverName();
    }

    public String getReceiverContact(){
        return receiver.getReceiverContact();
    }

    public String getReceiverAddress(){
        return receiver.getReceiverAddress();
    }

    public String getReceiverParcel(){
        return receiver.getCategory() + "(" + receiver.getType() + ")";
    }

    public String getReceiverParcelWeight(){
        return  receiver.getWeight() + "kg";
    }

    public String getReceiverInsurance(){
        return receiver.getInsurance();
    }

    public String getReceiverPayment(){
        if(receiver.getPayMethod().equals("COD")){
            return receiver.getPayMethod() + "(RM" + receiver.getShippingFee() + ")";
        }
        else{
            return receiver.getPayMethod();
        }
    }

    public String getReceiverShippingFee(){
        return receiver.getShippingFee();
    }

    public String getReceiverRemark(){
        return receiver.getRemark();
    }
    
}
