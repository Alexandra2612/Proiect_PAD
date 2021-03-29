# Proiect_PAD
Food Delivery

Proiect cu 2 clienti si un server (clientii : o aplicatie de web si una de android)

Acest proiect urmareste crearea unei aplicatii de livrare a mancarii.Cu ajutorul acesteia clientii,restaurantele,precum si cei ce se ocupa cu livrarea mancarii pot interactiona intr-un mod simplu si eficient.



Administratorul este cel ce va creea lista de restaurante disponibile in aplicatie.Pentru fiecare restaurant acesta va adauga meniurile corespunzatoare,ingredientele din care sunt facute produsele,imagini sugestive,precum si potentiale toping-uri.Fiecare produs si toping este insotit de un pret si un gramaj.Lista de restaurante si meniurile vor fi memorate intr-o baza de date.



Clientul se poate inregistra si conecta in aplicatie.Acesta va fi adaugat intr-o lista de utilizatori stocata in baza de date.Dupa autentificare,clientul poate adauga intr-o lista toate produsele pe care doreste sa le comande,lista care va fi trimisa mai apoi serverului.Trimiterea catre server a comenzii presupune si adaugarea unei metode de plata si chiar introducerea detaliilor despre contul din care se va efectua tranzactia in cazul in care clientul a ales modalitatea de plata cu cardul.Clientul va primi un mesaj de preluare a comenzii,precum si un timp maxim de livrare in momentul preluarii acesteia de catre persoana ce va aduce comanda.Pe langa mesaj,clientul va putea vizualiza si detalii precum numele,prenumele si numarul de telefon al celui ce ii livreaza comanda.La final clientul va trimite o cerere de deconectare,in urma careia va primi un mesaj corespunzator.



Persoana ce livreaza comenzi se poate de asemenea inregistra si conecta,reprezentand si aceasta un tip de client in aplicatie.Pentru ambele tipuri de clienti inregistarea se face printr-un username,o parola,numele,prenumele si e-mailul.Conectarea in aplicatie se face ori cu adresa de email si parola setata,ori cu facebook-ul.Totodata dupa conectare acestia isi vor adauga numarul de telefon pentru a putea comunica in caz de nevoie.Toate datele vor fi stocate in baza de date si trimise cumparatorului si livratorului in momentul preluarii comenzii.Parolele sunt singurele informatii ce nu vor fi transmise,iar acestea vor fi criptate pentru securitatea conturilor utilizatorilor.Pentru a prelua o comanda tipul de utilizator ce are aceasta optiune va putea vizualiza o lista cu comenzi si va putea sa selecteze o anumita comanda pe care in cazul in care va apasa pe butonul de accept o va avea atribuita lui.Atribuirea se face prin trimiterea unui mesaj de accept pentru o anumita comanda catre server care va scoate din lista de comenzi disponibile comanda respectiva.Dupa livrare acest tip de client va apasa pe butonul de comanda livrata si astfel va putea reveni la lista de comenzi disponibile pentru preluare.La final acesta se poate deconecta la fel ca si cumparatorii.


Tehnologii folosite:pentru baza de date vom folosi MySQL,pentru backend,Java,iar pentru frontend,React


Functionalitati:
- clientul isi poate creea un cont sau autentifica daca are deja un cont
- pentru autentificare se introduce adresa de mail si parola sau facebook-ul
- clientul isi poate adauga un numar de telefon si adresa
- clientul poate sa vada restaurantele si fara a se conecta 
- daca acesta doreste sa comande ceva trebuie sa se conecteze
- clientul poate sa aleaga un restaurant si sa vada detaliile despre acesta
- poate sa adauge in cos ceea ce doreste sa comande si sa introduca mentiuni
- apoi poate fi plasata comanda,dar nu inainte de a adauga detaliile despre plata si adresa
- dupa plasarea comenzii aceasta este introdusa intr-o lista de comenzi disponibile
- clientul poate oricand sa vizualizeze starea comenzii precum si eventuale mesaje de la livrator 
- lista de comenzi disponibile apare in contul livratorului
- livratorul se poate conecta si inregistra in aplicatie
- pentru inregistrarea livratorului trebuie primit un accept de la admin
- din lista de comenzi disponibile livratorul alege o comanda pe care o accepta 
- de la livrator clientul primeste detaliile de livrare
- acesta poate sa trimita mesaje clientului prin aplicatie
- dupa livrare va apasa butonul de comanda livrata si se va intoarce la lista de comenzi disponibile de unde va putea selecta o alta comanda
- atat clientul si livratorul se pot deloga din aplicatie
- adminul adauga restaurante si accepta livratori

