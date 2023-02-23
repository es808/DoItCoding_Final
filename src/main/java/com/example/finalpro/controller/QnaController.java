package com.example.finalpro.controller;

import com.example.finalpro.db.DBManager;
import com.example.finalpro.entity.Qna;
import com.example.finalpro.service.QnaService;
import com.example.finalpro.service.TicketService;
import com.example.finalpro.vo.QnaVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;

@Controller
@Setter
public class QnaController {
    @Autowired
    private QnaService qs;

    @Autowired
    private TicketService ts;

    @GetMapping("/qna/list")
    public ModelAndView list(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("list", qs.findAll());
        return mav;
    }

    @GetMapping("/qna/detail/{qna_no}")
    public ModelAndView detail(@PathVariable int qna_no, HttpSession session){
        ModelAndView mav=new ModelAndView("/qna/detail");

        Qna q =qs.findById(qna_no).get();
        String custidByQna_no=q.getCustomer().getCustid();
        String custidInSession=(String)session.getAttribute("id");
        if(!custidInSession.equals(custidByQna_no) && !custidInSession.equals("admin") && q.getQna_open().equals("n")){
            mav.addObject("msg","비공개 글입니다.");
            mav.setViewName("/error");
        }else {
            mav.addObject("q",qs.findById(qna_no).get());
        }


//        //비공개 글일 경우
//        if(qna_open.equals("n")){
//            //작성자가 맞는지 확인
//            QnaVO q=new QnaVO();
//            q.setQna_no(qna_no);
//            q.setCustid((String) session.getAttribute("id"));
//
//            // 작성자가 아니면
//            if(DBManager.checkWriter(q)!=1){
//                mav.addObject("msg","비공개 글입니다.");
//                mav.setViewName("/error");
//                //작성자면
//            }else{
//                mav.addObject("q",qs.findById(qna_no).get());
//            }
//        }else{
//            mav.addObject("q",qs.findById(qna_no).get());
//        }
        return mav;
    }

    @GetMapping("/qna/insert")
    public ModelAndView insertForm(HttpSession session){
        ModelAndView mav=new ModelAndView();

        return mav;
    }

    @PostMapping("/qna/insert")
    public ModelAndView insertSubmit(QnaVO q, HttpServletRequest request){
        ModelAndView mav=new ModelAndView("redirect:/qna/list");

        //파일 업로드
        String path=request.getServletContext().getRealPath("qna_files");
        MultipartFile uploadFile=q.getUploadFile();
        String fname=uploadFile.getOriginalFilename();
        q.setQna_fname(fname);

        if(q.getQna_answer()==null){
            q.setQna_answer("");
        }

        int re= DBManager.insertQna(q);

        if(re!=1) {
            //실패하면
            mav.setViewName("/error");
        }else{
            //성공하면
            if(fname != null && !fname.equals("")) {
                //fname이 있으면 (= 파일 업로드 했으면)
                try {
                    FileOutputStream fos = new FileOutputStream(path + "/" + fname);
                    FileCopyUtils.copy(uploadFile.getBytes(), fos);
                    fos.close();
                }catch (Exception e) {
                    System.out.println("예외발생:"+e.getMessage());
                }
            }
        }
        return mav;
    }

    //답글 등록 Ajax
    @ResponseBody
    @GetMapping("/qna/answer/update")
    public String updateAnswer(int qna_no, String qna_answer){
        QnaVO q=new QnaVO();
        q.setQna_no(qna_no);
        q.setQna_answer(qna_answer);
        return ""+DBManager.updateAnswer(q);
    }

    @ResponseBody
    @GetMapping("/qna/answer/delete")
    public int deleteAnswer(int qna_no){
        return DBManager.deleteAnswer(qna_no);
    }
}
