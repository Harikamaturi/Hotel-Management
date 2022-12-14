package com.guestservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import com.guestservice.exception.GuestNotFoundException;
import com.guestservice.model.GuestDetails;
import com.guestservice.repository.GuestDetailsRepository;
import com.guestservice.service.GuestDetailsService;





@SpringBootTest
class GuestServiceApplicationTests {



   @Autowired
    private GuestDetailsService guestService;



   @MockBean
    private GuestDetailsRepository guestDetailsRepository;




    @Test
    public void showAllGuestDetailsTest() throws GuestNotFoundException {
        List<GuestDetails> guestDetails = new ArrayList<>();
        GuestDetails g = new GuestDetails(1, "Harika", "877532352", "F", "harika@gmail.com", "hyderabad");
        guestDetails.add(g);
        when(guestDetailsRepository.findAll()).thenReturn(guestDetails);
        assertEquals(1, guestService.showAllGuestDetails().size());
    }
    @Test
    public void showGuestByIdTest() throws GuestNotFoundException {
        GuestDetails g = new GuestDetails(1, "Harika", "877532352", "F", "harika@gmail.com", "hyderabad");
        Optional<GuestDetails> guest = Optional.of(g);
        when(guestDetailsRepository.findById(1)).thenReturn(guest);
        assertEquals(g, guestService. showGuestById(1));
    }



   @Test
    public void addGuestDetailsTest() throws GuestNotFoundException {
        GuestDetails guest = new GuestDetails(1, "Harika", "877532352", "F", "harika@gmail.com", "hyderabad");
        when(guestDetailsRepository.insert(guest)).thenReturn(guest);
        assertEquals(guest, guestService.addGuestDetails(guest));
    }



   @Test
    public void updateGuestDetailsTest() throws GuestNotFoundException {
        GuestDetails g1 = new GuestDetails(1,"Harika", "877532352", "F", "harika@gmail.com", "hyderabad"); 
        GuestDetails g2 = new GuestDetails(1,"Harika", "877532352", "F", "harika@gmail.com", "hyderabad"); 
        Optional<GuestDetails> guest = Optional.of(g1);
        when(guestDetailsRepository.findById(1)).thenReturn(guest);
        when(guestDetailsRepository.save(g2)).thenReturn(g2);
        assertEquals(g2, guestService.updateGuestDetails(g2));
    }



   @Test
    public void deleteGuestDetailsTest() throws GuestNotFoundException {
        GuestDetails g = new GuestDetails(1, "Harika", "877532352", "F", "harika@gmail.com", "hyderabad");
        Optional<GuestDetails> guest = Optional.of(g);
        when(guestDetailsRepository.findById(1)).thenReturn(guest);
        assertEquals("Guest with the 1 Deleted Successfully!", guestService.deleteGuestDetails(1));



   }



}





   
   
 