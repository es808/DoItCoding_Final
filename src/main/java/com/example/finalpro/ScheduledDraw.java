package com.example.finalpro;

import com.example.finalpro.controller.DrawController;
import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
@Setter
public class ScheduledDraw {

    static int day;
    static Date date = new Date();
    @Autowired
    private DrawController drawController;

    @Autowired
    private TicketDAO ticketDAO;

    //매일 오후 12시에 다음날이 상영일인 상품에 대해 드로우 진행
    @Scheduled(cron = "0 0 12 * * ?")
    public void draw(){
        List<Ticket> tickets = ticketDAO.findAll();
        int toMonth = date.getMonth()+1;
        int toDay = date.getDate();
        for(Ticket t : tickets){

            String date = t.getTicket_date().substring(0,10);
            System.out.println(date);
            String arr[] = date.split("-");

            if(toMonth == Integer.parseInt(arr[1]) && toDay == Integer.parseInt(arr[2])-1){
                System.out.println("draw실행:"+ t.getTicketid());
                drawController.drawExec(t.getTicketid());
            }
        }
        Date date = new Date();
    }

}
