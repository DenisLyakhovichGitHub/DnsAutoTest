package models;

import java.io.Serializable;

// Класс "Смартфон"
public class TelevisorsJB implements Serializable {
  // Компания
  private String company;
  // Конструктор по умолчанию
  public TelevisorsJB() {

  }
  // Конструктор
  public TelevisorsJB(String company) {
    this.company = company;
  }
  // Сеттеры и геттеры
  // Компания
  public void setCompany(String company) {
    this.company = company;
  }
  public String getCompany() {
    return this.company;
  }
}
