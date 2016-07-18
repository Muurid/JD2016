package by.it.sinkevich.project.java;


public enum Action {

    INDEX {
        {
            command = new CommandIndex();
            viewPage = "/index.jsp";
        }
    },
    LOGIN {
        {
            command = new CommandLogin();
            viewPage = "/login.jsp";
        }
    },
    LOGIN_SEND_FORM {
        {
            command = new CommandLoginSendForm();
            viewPage = "/main.jsp";
        }
    },
    REGISTER {
        {
            command = new CommandRegister();
            viewPage = "/register.jsp";
        }
    },
    REGISTER_SEND_FORM {
        {
            command = new CommandRegisterSendForm();
            viewPage = "/login.jsp";
        }
    },
    LOGOUT {
        {
            command = new CommandLogout();
            viewPage = "/index.jsp";
        }
    },
    ERROR {
        {
            command = new CommandError();
            viewPage = "/error.jsp";
        }
    },
    PLACE_BET {
        {
            command = new CommandPlaceBet();
            viewPage = "/main.jsp";
        }
    },
    VIEW_RACES {
        {
            command = new CommandViewRaces();
            viewPage = "/main.jsp";
        }
    };

    public String viewPage;
    public ActionCommand command;
    public static String message = "message";
    public static String errorMessage = "errorMessage";
}
