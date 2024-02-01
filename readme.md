## Pentru ultimul proiect am folosit:

- **Factory** pentru creeare diferitelor tipuri de stock-uri: (Tech, Realestate, Agriculture, Energy)
- **Singleton** pentru a ma asigura ca este un singur StockMarket, nu prea ar avea sens sa fie mai multe, este o aplicatie mica conceputa sa ruleze doar pe un sintgur StockMarket
- **Command** dar nu pot spune ca ii perfect ca la carte, merge pe partea de TransactionsHistory acolo am folosit command, StockMarket da comanda la TransactionsHistory

### Ce merge in aplicatie ?
- poti avea useri
- poti sa cumperi si sa vinzi actiuni
- poti sa vezi istoricul tranzactiilor
- poti creste pretul actiunilor

### Ce nu merge in aplicatie ?
- chiar daca sunt si ClientUseri si AdminUseri nu este nici o diferenta intre ei (trebuia ca doar adminii sa poata creste pretul actiunilor)
- nu este un sistem de login, nu poti sa iti creezi un cont, nu poti sa iti schimbi parola, nu poti sa iti stergi contul
- ar mai fi trebuit sa fac un sistem de notificari, sa poti sa iti setezi un pret la care sa fii notificat cand se ajunge la el
- ar fi fost dragut daca era un sistem de vindere automata a actiunilor daca ating un anumit pret