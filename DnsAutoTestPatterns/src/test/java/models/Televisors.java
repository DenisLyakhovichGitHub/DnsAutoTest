package models;

import java.io.Serializable;
import models.valueobjects.Company;


// Класс "Телевизоры"
public class Televisors implements Serializable {
  // Производитель
  private Company company;
  // Модель
  private String model;
  // Конструктор по умолчанию
  public Televisors() {

  }
  // Конструктор
  public Televisors( Company company) {
    this.company = company;
  }
  // Сеттеры и геттеры
  // Производитель
  public void setCompany(Company company) {
    this.company = company;
  }
  public Company getCompany() {
    return this.company;
  }
  // Модель
  public void setModel(String model) {
    this.model = model;
  }
  public String getModel() {
    return model;
  }
}
