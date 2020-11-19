package kr.co.junyoung.eatgo.application;

import kr.co.junyoung.eatgo.domain.Reservation;
import kr.co.junyoung.eatgo.domain.ReservationRepository;
import kr.co.junyoung.eatgo.domain.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ReservationServiceTests {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        reservationService = new ReservationService(reservationRepository);
    }


    @Test
    public void addReservation(){
        Long reservationId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-25";
        String time = "20:00";
        Integer partySize = 20;

        Reservation mockReservation = Reservation.builder().name(name).build();
        given(reservationRepository.save(any())).will(invocation -> {
            Reservation reservation = invocation.getArgument(0);
            return reservation;
        });

        Reservation reservation = reservationService.addReservation(
                reservationId, userId, name, date, time, partySize);

        assertThat(reservation.getName(), is(name));

        verify(reservationRepository).save(any(Reservation.class));
    }
}