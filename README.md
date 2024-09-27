<h1>Task Management API</h1>

<h3>Description</h3>
<p>RESTful API developed for manager tasks. It creates, updates, retrieves and deletes tasks.
This API uses a H2 Database for storage and is useful for development, testing and studying.</p>

<h3>Features</h3>
<ul>
    <li><b>Create tasks:</b> add tasks in the H2 database.</li>
    <li><b>Update tasks:</b> update tasks based on what he user needs.</li>
    <li><b>Delete tasks:</b> remove tasks from the H2 database.</li>
    <li><b>Retrieve tasks:</b> search for tasks based on its ID or name.</li>
</ul>

<h3>Endpoints</h3>
<ol>
    <li><b>Creates a new task</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task</li>
	    <li><b>Method:</b> POST</li>
	    <li><b>Description:</b> Creates a new task.</li>
	</ul>
    </li>
    <li><b>Retrieves all tasks</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task</li>
	    <li><b>Method:</b> GET</li>
	    <li><b>Description:</b> Retrieves all task.</li>
	</ul>
    </li>
    <li><b>Retrieves tasks by name</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task?taskName=TASK_NAME</li>
	    <li><b>Method:</b> GET</li>
	    <li><b>Description:</b> Retrieves a task based on its name.</li>
	    <li><b>Parameters:</b> 'TASK_NAME' is a mandatory parameter.</li>
	</ul>
    </li>
    <li><b>Retrieves tasks by id</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task?id=TASK_ID</li>
	    <li><b>Method:</b> GET</li>
	    <li><b>Description:</b> Retrieves a task based on its id.</li>
	    <li><b>Parameters:</b> 'TASK_ID' is a mandatory parameter.</li>
	</ul>
    </li>
    <li><b>Update tasks</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task?id=TASK_ID</li>
	    <li><b>Method:</b> PUT</li>
	    <li><b>Description:</b> Updates a task based on its id.</li>
	    <li><b>Parameters:</b> 'TASK_ID' is a mandatory parameter.</li>
	</ul>
    </li>
    <li><b>Delete tasks</b>
        <ul>
	    <li><b>URL:</b> localhost:8080/task?id=TASK_ID</li>
	    <li><b>Method:</b> GET</li>
	    <li><b>Description:</b> Deletes a task based on its id.</li>
	    <li><b>Parameters:</b> 'TASK_ID' is a mandatory parameter.</li>
	</ul>
    </li>
</ol>

<h3>Using the application</h3>
<p>The application uses an 'In Memory' database, so no need to install any database. The configuration of the database is made in the "application.properties" and creates a single table called "task" when the application starts using the "data.sql" file, then it inserts 3 tasks in the table using the method populatesH2Database().

Its possible to teste the API with tools like Postman, sending HTTP requests to the mentioned endpoints.</p>
