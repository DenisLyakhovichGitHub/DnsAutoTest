package models;

import java.io.Serializable;
import models.valueobjects.Company;

// Класс "Телевизор"
public class TelevisorsVO implements Serializable {
  // Компания
  private Company company;
  // Конструктор по умолчанию
  public TelevisorsVO() {

  }
  // Конструктор
  public TelevisorsVO(Company company) {
    this.company = company;
  }
  // Сеттеры и геттеры
  // Компания
  public void setCompany(Company company) {
    this.company = company;
  }
  public Company getCompany() {
    return this.company;
  }
}
