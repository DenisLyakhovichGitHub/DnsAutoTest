package webdriverfactory;

public enum OptionName {
  // Имена стратегий загрузки страницы
  NONE ("NONE"), // стратегия normal
  EAGER ("EAGER"), // стратегия eager
  NORMAL ("NORMAL"); // стратегия normal

  private String optionName; // имя стратегиии

  // Приватный конструктор
  private OptionName(String optionName) { this.optionName = optionName; }

  // Переопределенный метод toString()
  @Override
  public String toString() {
    return String.valueOf(this.optionName);
  }

  // Возврат константы по строковому значению константы
  public static OptionName fromString(String optionName) {
    if (optionName != null) {
      for(OptionName o : OptionName.values()) {
        if (optionName.equalsIgnoreCase(o.optionName)) {
          return o;
        }
      }
    }
    return null;
  }

  // Получение имени стратегии
  public String getBrowserName() {
    return this.optionName;
  }
}
