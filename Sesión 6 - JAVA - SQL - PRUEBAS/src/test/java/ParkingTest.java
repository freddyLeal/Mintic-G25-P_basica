/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.parking25.controllers.ParkingController;
import com.mycompany.parking25.models.Parking;
import com.mycompany.parking25.models.ParkingLog;
import com.mycompany.parking25.utils.db.DBConf;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import models.GeneralModel;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author user
 */
public class ParkingTest {
    
    private ParkingController parCtr = new ParkingController();
    
    public ParkingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBConf.testMode = true;
        new GeneralModel().startDBTesting();
    }
    
    @After
    public void tearDown() {
    }    
    
    
    
    @Test
    public void get_list_parking_free_test(){        
        List<Parking> parkingList = parCtr.getFreeParkingList();
        
        List<Integer> parkingIdList = parkingList.stream()
                                        .map(parking -> parking.getId())
                                        .collect( Collectors.toList() );
        
        assertThat(parkingIdList, CoreMatchers.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)) );
    }
    
    
    @Test
    public void get_list_parking_free_v2_test(){
        List<Parking> parkingList = parCtr.getFreeParkingList();
        
        if( parkingList.size() != 9 )
            assertTrue(false);
        
        for(Parking par : parkingList){
            if( par.getId() < 1  && par.getId() > 9 )
                assertTrue(false);
        }
    }
    
    
    @Test
    public void get_list_parking_not_free_test(){
        List<Parking> parkingList = parCtr.getNotFreeParkingList();
        
        List<Integer> parkingIdList = parkingList.stream()
                                        .map(parking -> parking.getId())
                                        .collect( Collectors.toList() );
        
        assertThat(parkingIdList, CoreMatchers.is(Arrays.asList(10)) );
    }
    
    
    @Test
    public void get_list_all_parking_test(){
        List<Parking> parkingList = parCtr.getAllParkingList();
        
        List<Integer> parkingIdList = parkingList.stream()
                                        .map(parking -> parking.getId())
                                        .collect( Collectors.toList() );
        
        assertThat(parkingIdList, CoreMatchers.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) );
    }
    
    
    @Test
    public void parking_new_arrived_test(){
        parCtr.setArrivedToParking(3, "KID475");
        
        try{
            Parking parkingEdited = (Parking) new Parking().find(3);
            assertTrue( !parkingEdited.getIsFree()  );
            assertEquals( parkingEdited.getCarNumber() , "KID475");
            assertNotNull( parkingEdited.getArrived() );
        } catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }
    
    
    @Test
    public void parking_departure_test(){
        try {
            parCtr.setArrivedToParking(1, "KDU748");
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
        
        try {
            parCtr.setDepartureToParking(1);
        } catch (Exception ex) {
            assertTrue(false);
        }
        Parking par = null;
        try {
            par = (Parking) new Parking().find(1);
            assertTrue( par.getIsFree() );
            assertNull(par.getCarNumber());
            assertNull( par.getArrived() );
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
        
        try {
            ParkingLog log = (ParkingLog) new ParkingLog().find(1);
            assertEquals(log.getCode(), par.getCode());
            assertEquals(log.getCarNumber(), "KDU748");
            assertNotNull( log.getArrived() );
            assertNotNull( log.getDeparture() );
            assertNotNull( log.getMinutes() );
            assertEquals(log.getParkingId(), par.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
    
    
    
    
    
}
