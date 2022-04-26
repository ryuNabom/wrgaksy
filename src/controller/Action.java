package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    // 인터페이스 == 강제성 + 재사용 용이
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
