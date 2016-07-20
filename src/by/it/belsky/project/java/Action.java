package by.it.belsky.project.java;


enum Action {
    INDEX{
        {
            this.command = new CommandIndex();
            this.inPage = "/index.jsp";
            this.okPage = "/index.jsp";
        }

    },
    ALLUSERS {
        {
            this.command = new CommandAllUsers();

            this.inPage = "/emptyallusers.jsp";
            this.okPage = "/allusers.jsp";
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage="/signup.jsp";
            this.okPage ="/login.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/login.jsp";
            this.okPage ="/main.jsp";
        }
    },
    CREATEFORM {
        {
            this.command = new CommandCreateform();
            this.inPage="/createform.jsp";
            this.okPage ="/main.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/logout.jsp";
            this.okPage ="/";
        }
    },
    ERROR {
        {
//            this.command = new CommandLogout();

        }

    };

    public String inPage="/error.jsp";
    public String okPage ="/page.jsp";
    public String fPage ="/profilepage.jsp";
    public String kPage ="/noforms.jsp";

    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}