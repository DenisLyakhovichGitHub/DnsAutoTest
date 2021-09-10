package models;

import models.valueobjects.Company;

// Класс строитель объекта "Телевизоры"
public class TelevisorsBuilder {
  // Производитель
  private Company company;
  // Конструктор
  public TelevisorsBuilder(Company company) {
    this.company = company;
  }
  // Создание объекта "Телевизор"
  public Televisors build() {
    Televisors televisors = new Televisors();
    televisors.setCompany(this.company);
    return televisors;
  }
}
