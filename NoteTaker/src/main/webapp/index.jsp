<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NoteTaker: Home Page</title>
    <%@include file="all_js_css.jsp"%>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            margin: 0; /* Remove default margin */
            display: flex; /* Use flex on body */
            flex-direction: column; /* Arrange content in a column */
            align-items: center; /* Center content horizontally */
        }

        .container {
            text-align: center; /* Center-align the text */
            width: 100%; /* Full width to accommodate the navbar */
        }

        .logo {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-grow: 1; /* Allow the image container to grow */
        }

        .icon-format {
            height: 500px;
            width: 500px;
            border-radius: 50px;
            transition: transform 0.3s ease, box-shadow 0.3s ease; /* Smooth transition for hover effects */
        }

        /* Hover effect for the image */
        .icon-format:hover {
            transform: scale(1.02); /* Zoom in slightly */
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.4); /* Add a subtle shadow */
        }
    </style>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%> <!-- Navbar inclusion -->
    <br>
    <h1>Notes+</h1>
    <br>
</div>
<div class="logo">
    <!-- Wrap the image with an anchor tag to make it a hyperlink -->
    <a href="add_notes.jsp">
        <img src="notability-note-taking-2023-10-03.avif" class="icon-format" alt="Notability Note Taking">
    </a>
</div>
</body>
</html>
