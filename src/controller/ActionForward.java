package controller;

public class ActionForward {
    private boolean redirect; // 방식 (데이터 전송 여부)
    private String path; // 경로

    // redirect 방식 T == 전달할 정보가 없음
    // forward 방식 F == 전달할 정보가 있음
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getPath() {
        return path;
    }
}
