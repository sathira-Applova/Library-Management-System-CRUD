package org.userwebapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.userwebapp.model.Book;
import org.userwebapp.service.BooksDAO;
import org.userwebapp.service.BooksDAOI;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

//import static sun.security.ssl.SSLLogger.logger;


@Controller
public class ControllerHome {

    private static final Logger logger = LogManager.getLogger(ControllerHome.class);

    private BooksDAO booksImp = new BooksDAOI();

    @RequestMapping(value = "/")
    public ModelAndView display(ModelAndView mav) {

        ArrayList<Book> bookList = (ArrayList<Book>) booksImp.getBookList();
        mav.addObject("bookList", bookList);
        mav.setViewName("regUserHome");
        return mav;
    }

    //displays all books to registered user
    @RequestMapping(value = "/regUserID") //this should have some kind of parameter
    public ModelAndView loginDisplay(ModelAndView mav) {

        ArrayList<Book> bookList = (ArrayList<Book>) booksImp.getBookList();
        mav.addObject("bookList", bookList);
        mav.setViewName("regUserhome");
        return mav;
    }

    @RequestMapping(value = "newForm", method = RequestMethod.GET)
    public ModelAndView newForm(ModelAndView mav) {
        Book book = new Book();
        mav.addObject("book", book);
        mav.setViewName("bookForm");
        return mav;
    }

    @RequestMapping(value = "saveBook", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute Book book) { //It binds the data from the form to this book instance of the Book class

//        logger.info(book.getName());
//        logger.info("Hi");
        if (book.getBookID() == 0)
            booksImp.create(book);
        else
            booksImp.update(book);
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView showUpdatePage(HttpServletRequest req) {
        int bookID = Integer.parseInt(req.getParameter("bookID")); //To get the id sent from request from regUserHome.jsp
        Book book = booksImp.retrieveSingleBook(bookID);

        ModelAndView mav = new ModelAndView("bookForm");
        mav.addObject("book", book);
        return mav;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ModelAndView deleteBook(HttpServletRequest req) {
        booksImp.delete(Integer.parseInt(req.getParameter("bookID")));

        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
}
