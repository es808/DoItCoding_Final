package com.example.finalpro.service;

import com.example.finalpro.dao.TicketDAO;
import com.example.finalpro.entity.Ticket;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class TicketService {
    @Autowired
    private TicketDAO dao;

    public List<Ticket> findAll(){return dao.findAll();}

    //public Ticket findByTicketid(int ticketid){return dao.findByTicketid(ticketid);}

    public void insertTicket(Ticket ticket, HttpServletRequest request){

        // 파일 업로드하기
        String path =request.getServletContext().getRealPath("/images");
        String fname = "";
        String fname_main = "";
        MultipartFile uploadFile = ticket.getUploadFile();
        MultipartFile uploadFile_main = ticket.getUploadFile_main();
        fname = uploadFile.getOriginalFilename();
        fname_main = uploadFile_main.getOriginalFilename();

        if(fname != null && !fname.equals("")){
            try{
                byte []data = uploadFile.getBytes();
                FileOutputStream fos = new FileOutputStream(path + "/" + fname);
                fos.write(data);
                fos.close();
            }catch(Exception e){
                System.out.println("에러"+e.getMessage());
            }
        }else{
            fname = "";
        }

        if(fname_main != null && !fname_main.equals("")){
            try{
                byte []data = uploadFile_main.getBytes();
                FileOutputStream fos = new FileOutputStream(path + "/" + fname_main);
                fos.write(data);
                fos.close();
            }catch(Exception e){
                System.out.println("에러"+e.getMessage());
            }
        }else{
            fname_main = "";
        }

        ticket.setImg_fname(fname);
        ticket.setImg_fname_main(fname_main);

        dao.save(ticket);
    }



}
