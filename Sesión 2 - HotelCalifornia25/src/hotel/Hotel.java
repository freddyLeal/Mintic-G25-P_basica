package hotel;


public class Hotel {
    
    public static Holder holder = new Holder();
    
    
    public static void getAvailableRooms(int roomType){
        String emptyRooms = "";
        int countEmptyRooms = 0;
        switch(roomType){
            case 1:
                for(int j = 0; j < holder.luxury_double_room.length; j++){
                    if( holder.luxury_double_room[j] == null ){
                        emptyRooms += (j+1) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 2:
                for(int j = 0; j < holder.single_double_room.length; j++){
                    if( holder.single_double_room[j] == null ){
                        emptyRooms += (j+11) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 3:
                for(int j = 0; j < holder.luxury_simple_room.length; j++){
                    if( holder.luxury_simple_room[j] == null ){
                        emptyRooms += (j+21) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            case 4:
                for(int j = 0; j < holder.single_simple_room.length; j++){
                    if( holder.single_simple_room[j] == null ){
                        emptyRooms += (j+41) + ", ";
                        countEmptyRooms++;
                    }
                }
                break;
            default:
                System.out.println("Opción no valida");
        }
        
        if( emptyRooms.length() > 1){
            emptyRooms = emptyRooms.substring(0, emptyRooms.length()-2);
        }
        System.out.println("Las habitaciones vacias son: " + emptyRooms);
        System.out.println("Número de habitaciones vacias: " + countEmptyRooms);
    }
    
    
    public void bookingRoom(){
        
    }
    
    public void deallocateRoom(){
        
    }
    
    public void featuresRoom(){
        
    }
    
    public void orderFood(){
        
    }
    
    
    
}
