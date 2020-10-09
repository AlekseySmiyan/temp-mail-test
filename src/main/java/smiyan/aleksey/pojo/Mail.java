package smiyan.aleksey.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mail {

    @JsonProperty("mail_from")
    private String mailFrom;

    @JsonProperty("mail_subject")
    private String mailSubject;

    @JsonProperty("mail_text")
    private String mailText;

    public String getMailFrom() {
        return mailFrom;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public String getMailText() {
        return mailText;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailFrom='" + mailFrom + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", mailText='" + mailText + '\'' +
                '}';
    }
}
