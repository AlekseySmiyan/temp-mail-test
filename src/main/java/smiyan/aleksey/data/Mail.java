package smiyan.aleksey.data;

public enum Mail {

    MAIL_FROM("tort.ua<order@tort.ua>"),
    MAIL_SUBJECT("Зарегистрирован новый клиент на tort.ua"),
    MAIL_TEXT("Здравствуйте!\n" +
            "Благодарим за регистрацию на tort.ua.\n" +
            "При регистрации вы оставили следующие данные:\n" +
            "E-Mail: %s\n" +
            "Пароль: %s\n" +
            "ФИО: %s Телефон: %s \n" +
            "Адрес: \n" +
            "Комментарий: \n" +
            "С уважением,\n" +
            "администрация tort.ua.");

    private final String value;

    public String getValue() {
        return value;
    }

    Mail(String value) {
        this.value = value;
    }
}
