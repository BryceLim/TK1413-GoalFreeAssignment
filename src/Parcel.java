public class Parcel {
    
    String type, category, weight, paymentMethod, shippingfee, remark;
    Boolean insurance;
    Receiver receiver;

    public Parcel(String tp, String cat, String wg, String pay, String ship, String rem, Boolean ins, Receiver rec){
        type = tp;
        category = cat;
        weight = wg;
        paymentMethod = pay;
        shippingfee = ship;
        remark = rem;
        insurance = ins;
        receiver = rec;
    }

    public String getType(){
        return type;
    }

    public String getCategory(){
        return category;
    }

    public String getWeight(){
        return weight;
    }

    public String getPayMethod(){
        return paymentMethod;
    }

    public String getShippingFee(){
        return shippingfee;
    }

    public String getRemark(){
        return remark;
    }

    public String getInsurance(){
        if(insurance == true){
            return "Item is insured";
        }
        else{
            return "Item is not insured";
        }
    }
    
    public String getReceiverName(){
        return receiver.getName();
    }

    public String getReceiverEmail(){
        return receiver.getEmail();
    }

    public String getReceiverContact(){
        return receiver.getContact();
    }

    public String getReceiverAddress(){
        return receiver.getAddress();
    }

    public String toString(){
        return getReceiverName();  //getType()+ "(" + getWeight() + "kg)";
    }
}
