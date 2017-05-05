# Reseau_social_projetJEE
<p><p>
Equipe composée de : <p>
- Cyril Bouriez <p>
- Alexandre Allais <p>
- Amandine Bucas
<p><p>
TODOO : Création application "myEpsi" (JEE). Elle permet la gestion des messages stockés dans une base de données HsqlDB. <p><p>
TODOO : Implémentation des actions en Servlet. <p><p>
TODOO : Implémentation des pages en JSP. <p><p>
TODOO : Un message doit être défini par : <p>
- Un identifiant unique numérique (débute à 1) avec incrémentage automatique <p>
- Un titre (texte de 140 caractères) <p>
- Une description (memo) <p>
- Un statut (public, privé, archivé) <p>
- Un nombre de vue <p>
- Une date de création <p>
- Une date de modification <p><p>
TODOO : Si le message est public alors il peut être vu par tous les utilisateurs <p>
TODOO : Si le message est privé alors il ne peut pas être vu par tous les utilisateurs <p><p>
TODOO : A l'arrivée sur la page d'accueil, possibilité de créer un compte à l'aide de : <p>
- Un email (qui doit être l'identifiant unique) <p>
- Un mot de passe <p>
- Une confirmation du mot de passe (vérification qu'il soit identique au mot de passe) <p><p>
TODOO : Création d'un administrateur. Ce dernier pourra : <p>
- Gérer les utilisateur (créer, modifier, supprimer) <p>
- Supprimer les messages <p>
- Créer un message (automatiquement public) <p><p>
TODOO : Après connexion, la page d'accueil permet de : <p>
- Présenter la liste des messages (titre, auteur, date de modification) disponibles. Les messages affichés seront les messages de l'utilisateur, les messages publics, les messages de l'administrateur. Il n'y aura pas d'affichier les messages archivés des autres utilisateurs.
- Affichage d'icônes devant le titre permettant de reconnaître les messages des autres utilisateurs, de l'administrateur et les messages archivés.
- Bouton "Créer" permettant d'afficher un formulaire vide avec un bouton "Ajouter" et un bouton "Annuler". <p>
- En cliquant sur un ligne du message qui est en cours d'édition, l'utilisateur peut afficher le détail, modifier la ligne, supprimer la ligne ou revenir à la page d'accueil. <p><p>
TODOO : Pages responsives <p><p>
TODOO : Création d'une url permettant l'affichage du message en consultation avec l'id en paramètre (ex : http://localhost:8080/myEpsi/message?ID=1. Réponse créée avec une page HTML de consultation. <p><p>
TODOO : Mise en place des logs avec log4j : <p>
- Les logs doivent afficher une trace de niveau INFO à chaque début d'exécution d'une servlet. <p>
- Les requêtes doivent être logées en niveau DEBUG. <p>
- En cas de test de connexion en erreur, le login testé devra être affiché en niveau ERROR. <p>
- 2 logs afficheront en niveau ERROR le nombre de messages présents en base et le nombre d'utilisateurs au démarrage de l'application. <p><p>
TODOO : Affichage du niveau en cours des logs grâce à un composant JMX dans la Jconsole. Permettant de le changer en cliquant sur un bouton "Debug", "Info", ou "Error". <p><p>
TODOO : Affichage du nombre de messages dan la base et de poster un message pour l'administrateur grâce à un autre composant JMX. <p><p>
TODOO : Mise en place des tests d'intégration suivant avec Junit dans le projet : <p>
- Impossibilité de créer 2 comptes avec le même email. <p>
- Impossibilité pour un utilisateur de supprimer un message qui ne lui appartient pas. <p>
- Impossibilité pour un utilisateur de voir les messages archivés et privés des autres utilisateurs. <p>
- Impossibilité de supprimer un compte administrauteur. <p><p><p>
ELEMENTS A RENDRE : <p>
- Le war de déploiement <p>
- Les sources sur Git <p>
- La base de données <p>
- Les tests unitaires 
