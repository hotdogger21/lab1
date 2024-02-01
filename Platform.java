public class Platform {

    protected Boolean rampOpen;



    private int platformangle;


    private Truck parent;

    public Platform(Truck parent){
        this.parent = parent;

    }

    public void raisePlatform(){

        if (parent.currentSpeed > 0){
            throw new RuntimeException("truck must be still before raising platform!");
        }
        else {
            while(platformangle < 70){
                platformangle= (Math.min(70, platformangle + 1));
                if(platformangle == 70){
                    rampOpen = true;
                }
            }
        }

    }

    public void lowerPlatform(){
        if (parent.currentSpeed > 0){
            throw new RuntimeException("truck must be still before lowering platform!");
        }
        while (platformangle > 0){
            platformangle = Math.max(0, platformangle - 1);
            if (platformangle == 0){
                rampOpen = false;
            }
        }
    }


    public boolean getRampOpen(){
        return rampOpen;
    }


    public int getPlatformangle() {
        return platformangle;
    }










}
