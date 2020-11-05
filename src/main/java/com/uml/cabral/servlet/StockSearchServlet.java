package com.uml.cabral.servlet;

import com.uml.cabral.model.StockQuery;
import com.uml.cabral.model.StockQuote;
import com.uml.cabral.services.DatabaseStockService;
import com.uml.cabral.services.ServiceFactory;
import com.uml.cabral.services.StockServiceException;
import com.uml.cabral.util.Interval;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet("/stocks")
public class StockSearchServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseStockService DBstockService = ServiceFactory.getStockServiceInstance();
        String symbol = request.getParameter("symbol");
        String date_from = request.getParameter("date_from");
        String date_until = request.getParameter("date_until");
        try {
            StockQuery stockQuery = new StockQuery(symbol, date_from, date_until);
            List<StockQuote> stockQuoteList = DBstockService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil(), Interval.DAY);

            HttpSession session = request.getSession();
            session.setAttribute("quotes", stockQuoteList);

            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher =
                    servletContext.getRequestDispatcher("/showStockQuotes.jsp");
            dispatcher.forward(request, response);
        }catch(ParseException e){
            System.out.println("Parsing error: " + e.getMessage());
        }catch (StockServiceException e){
            System.out.println("Stock Service Error: " + e.getMessage());
        }
    }

}
