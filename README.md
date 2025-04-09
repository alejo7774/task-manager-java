# 💼📋 GESTOR DE TAREAS EN JAVA (CONSOLA + SQLITE)

Este es un proyecto personal desarrollado con **Java + SQLite**, que permite gestionar tareas personales desde la consola de comandos. Ofrece funcionalidades básicas pero completas de un sistema de tareas: crear, listar, editar, completar, eliminar y filtrar.

---

## 🎯 Funcionalidades

✅ Crear tareas con:
- Título
- Descripción
- Fecha límite

📋 Listar tareas registradas (ordenadas por fecha)  
✏️ Editar tareas por ID  
✅ Marcar tareas como completadas  
❌ Eliminar tareas existentes  
🔍 Filtrar tareas por estado: pendientes o completadas  
💾 Almacenamiento persistente en base de datos SQLite  

---

## 🛠 Tecnologías usadas

- ☕ **Java 17**
- 🗃 **SQLite**
- 🔗 **JDBC** (conexión con base de datos)
- 💻 **Visual Studio Code**

> Estructurado en capas (`model`, `dao`, `main`) siguiendo buenas prácticas y separación de responsabilidades.

---

## 🧪 Cómo ejecutar en local

1. 📦 Clona el repositorio

```bash
git clone https://github.com/tu_usuario/task-manager-java.git
cd task-manager-java

2. 🔗 Descarga el driver JDBC para SQLite
👉 Descargar aquí https://github.com/xerial/sqlite-jdbc/releases

Colócalo en la carpeta /lib

3. 🛠 Compila el proyecto
javac -cp ".;lib/sqlite-jdbc-3.42.0.0.jar" -d out src/main/java/main/App.java src/main/java/dao/*.java src/main/java/model/*.java
(En macOS/Linux cambia ; por :)

4. ▶ Ejecuta la aplicación
java -cp ".;lib/sqlite-jdbc-3.42.0.0.jar;out" main.App


📂 Estructura del proyecto
task-manager-java/
│
├── lib/                         # Driver SQLite JDBC (.jar)
├── src/
│   └── main/
│       └── java/
│           ├── main/           # App.java (main)
│           ├── dao/            # DBConnection.java, TaskDAO.java
│           └── model/          # Task.java
├── tasks.db                    # Base de datos local
├── README.md                   # Documentación
├── .gitignore                  # Exclusiones para Git
└── out/                        # Código compilado (opcional)


👨‍💻 Autor
Alejandro Mosquera
📧 alejandrom8607@gmail.com
📍 Zaragoza, España
💼 Desarrollador de Aplicaciones Multiplataforma

📃 Licencia
Este proyecto se distribuye bajo licencia MIT.
¡Eres libre de usarlo, modificarlo y compartirlo! 🚀


¿Te gustó este proyecto? ⭐ Dale una estrella y sígueme para más ideas.