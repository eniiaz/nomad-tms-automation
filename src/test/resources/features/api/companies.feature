Feature: Company component at API and UI level tests

  @companyAPI @companies @smoke @regression
  Scenario Outline: Company creation for API testing

    Given user makes an api call to create a company with "<companyName>" "<email>" "<taxId>" "<dot>" at endpoint "<endpoint>"

    Examples:
      | companyName  | taxId    | email           | dot      | endpoint                                      |
      | Cukes jd LLC | 04982048 | cukes@gmail.com | 4984298  | https://nomadtms.up.railway.app/api/companies |
      | CC LLC       | 235253   | ghs@gmail.com   | 24523    | https://nomadtms.up.railway.app/api/companies |
      | SS LLC       | 35223    | ccs@gmail.com   | 6432353  | https://nomadtms.up.railway.app/api/companies |
      | Last Inc LLC | 248924   | ndksh@gmail.com | 78985645 | https://nomadtms.up.railway.app/api/companies |