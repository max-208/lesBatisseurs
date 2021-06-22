  _________     _                 ____        _                                       ___    
/|__/   \__|\  | |               |  _ \      | | (_)                                 /_._\   
\|__\___/__|/  | |     ___  ___  | |_) | __ _| |_ _ ___ ___  ___ _   _ _ __ ___      / ° \   
     |/|       | |    / _ \/ __| |  _ < / _` | __| / __/ __|/ _ \ | | | '__/ __|    / / \ \  
     |/|       | |___|  __/\__ \ | |_) | (_| | |_| \__ \__ \  __/ |_| | |  \__ \   //     \\ 
     |/|       |______\___||___/ |____/ \__,_|\__|_|___/___/\___|\__,_|_|  |___/  //       \\
     /.\                                                                         /           \
     \_/ 

ces commandes sont a effectuer dans le fichier contenant ce readme.txt
ce programme a été compilé en java 16 : https://www.oracle.com/java/technologies/javase-jdk16-downloads.html
il est cependant compatible jusqu'a java 11 : https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

╭─────────────────────────────────────────────────────────────────────────────────────────────╮
|                                                                                             |
|                          [ compiler le programme et faire un jar ]                          |
|                                                                                             |
╰─────────────────────────────────────────────────────────────────────────────────────────────╯
ant jar

╭─────────────────────────────────────────────────────────────────────────────────────────────╮
|                                                                                             |
|                       [ executer l'interface graphique du programme ]                       |
|                                                                                             |
╰─────────────────────────────────────────────────────────────────────────────────────────────╯
java -jar build/jar/Start-1.0.jar

╭─────────────────────────────────────────────────────────────────────────────────────────────╮
|                                                                                             |
|                       [ executer l'interface terminale du programme ]                       |
|                                                                                             |
╰─────────────────────────────────────────────────────────────────────────────────────────────╯
java -jar build/jar/Start-1.0.jar terminal
