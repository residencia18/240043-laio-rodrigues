import sqlite3
from datetime import datetime

# Conectar ao banco de dados (ou criar um novo se não existir)
conn = sqlite3.connect('tasks.db')
c = conn.cursor()

# Criar a tabela de tarefas se ainda não existir
c.execute('''
    CREATE TABLE IF NOT EXISTS tasks (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT NOT NULL,
        description TEXT,
        due_date DATE,
        completed BOOLEAN DEFAULT 0
    )
''')
conn.commit()

def add_task(title, description, due_date):
    c.execute('''
        INSERT INTO tasks (title, description, due_date)
        VALUES (?, ?, ?)
    ''', (title, description, due_date))
    conn.commit()

def list_all_tasks():
    c.execute('''
        SELECT * FROM tasks
    ''')
    return c.fetchall()

def mark_task_as_completed(task_id):
    c.execute('''
        UPDATE tasks
        SET completed = 1
        WHERE id = ?
    ''', (task_id,))
    conn.commit()

def list_pending_tasks():
    c.execute('''
        SELECT * FROM tasks
        WHERE completed = 0
    ''')
    return c.fetchall()

def list_completed_tasks():
    c.execute('''
        SELECT * FROM tasks
        WHERE completed = 1
    ''')
    return c.fetchall()

def delete_task(task_id):
    c.execute('''
        DELETE FROM tasks
        WHERE id = ?
    ''', (task_id,))
    conn.commit()

def search_tasks(keyword):
    c.execute('''
        SELECT * FROM tasks
        WHERE title LIKE ? OR description LIKE ?
    ''', (f'%{keyword}%', f'%{keyword}%'))
    return c.fetchall()

def get_statistics():
    c.execute('''
        SELECT COUNT(*) AS total_tasks,
               COUNT(CASE WHEN completed = 1 THEN 1 END) AS completed_tasks,
               COUNT(CASE WHEN completed = 0 THEN 1 END) AS pending_tasks,
               MIN(due_date) AS oldest_task,
               MAX(due_date) AS newest_task
        FROM tasks
    ''')
    return c.fetchone()

# Exemplos de uso:

# Adicionar uma tarefa
add_task("Comprar mantimentos", "Leite, ovos, pão", "2023-12-01")

# Listar todas as tarefas
print("Todas as tarefas:")
print(list_all_tasks())

# Marcar uma tarefa como concluída
mark_task_as_completed(1)

# Listar tarefas pendentes e concluídas
print("\nTarefas Pendentes:")
print(list_pending_tasks())
print("\nTarefas Concluídas:")
print(list_completed_tasks())

# Excluir uma tarefa
delete_task(2)

# Pesquisar tarefas com base em uma palavra-chave
print("\nPesquisar tarefas:")
print(search_tasks("comprar"))

# Obter estatísticas
print("\nEstatísticas:")
print(get_statistics())