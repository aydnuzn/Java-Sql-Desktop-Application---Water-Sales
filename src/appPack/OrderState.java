
package appPack;

public enum OrderState {
    Preparing("Hazırlanıyor"),
    Sent("Siparişiniz Yolda"),
    Delivered("Telim Edildi");
    
    private final String name;

    private OrderState(String name) {
        this.name = name;
    //    System.out.println(this.name);
    }
    
    public String getDesc(){
        return this.name;
    }
}
