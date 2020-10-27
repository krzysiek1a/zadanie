Feature: Zadanie rekrutacyjne
  Scenario Outline: Test allegro
    Given wchodzimy na strone "<url>"
    When wpisujemy w wyszukiwarke "<phone>"
    And wybieramy kolor czarny
    And zliczamy ilość wyświetlonych telefonów na pierwszej stronie wyników i ilość prezentujemy w consoli
    Then szukamy największej ceny na liście i wyświetlamy w konsoli
    And największej ceny dodajemy "<vat>"

    Examples:
    |url                  |phone    |vat|
    |http://www.allegro.pl|Iphone 11|23 |