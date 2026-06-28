import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class TechNovaServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);

        server.createContext("/", exchange -> {

            String html = """
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TechNova Solutions</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,Helvetica,sans-serif;
}

body{
    background:linear-gradient(135deg,#0f172a,#1e3a8a,#3b82f6);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    color:white;
}

.container{
    width:90%;
    max-width:1100px;
}

.card{
    background:rgba(255,255,255,0.12);
    backdrop-filter:blur(15px);
    border-radius:20px;
    padding:40px;
    box-shadow:0 20px 40px rgba(0,0,0,.3);
    text-align:center;
}

h1{
    font-size:42px;
    margin-bottom:15px;
}

p{
    font-size:18px;
    color:#f1f5f9;
    margin-bottom:30px;
}

button{
    padding:15px 35px;
    border:none;
    border-radius:10px;
    background:#22c55e;
    color:white;
    font-size:18px;
    cursor:pointer;
    transition:.3s;
}

button:hover{
    background:#16a34a;
    transform:scale(1.05);
}

.grid{
    margin-top:40px;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(220px,1fr));
    gap:20px;
}

.box{
    background:white;
    color:#111827;
    padding:25px;
    border-radius:15px;
    transition:.3s;
}

.box:hover{
    transform:translateY(-8px);
}

.box h2{
    font-size:40px;
    color:#2563eb;
}

.box p{
    color:#555;
    margin-top:10px;
}

footer{
    margin-top:30px;
    color:white;
    font-size:15px;
}

#status{
    margin-top:20px;
    font-size:22px;
    color:#22c55e;
    font-weight:bold;
}
</style>

</head>
<body>

<div class="container">

<div class="card">

<h1>🚀 TechNova Solutions</h1>

<p>Professional Java Application Running Successfully on AWS EC2</p>

<button onclick="checkStatus()">Check Application</button>

<div id="status"></div>

<div class="grid">

<div class="box">
<h2>150+</h2>
<p>Projects Completed</p>
</div>

<div class="box">
<h2>50+</h2>
<p>Happy Clients</p>
</div>

<div class="box">
<h2>99%</h2>
<p>Success Rate</p>
</div>

<div class="box">
<h2>24/7</h2>
<p>Support Available</p>
</div>

</div>

<footer>
Java | HTML | CSS | JavaScript | AWS EC2
</footer>

</div>

</div>

<script>
function checkStatus(){
    document.getElementById("status").innerHTML =
    "✅ Java Web Server is Running Successfully!";
}
</script>

</body>
</html>
""";

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, html.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(html.getBytes());
            os.close();
        });

        server.start();

        System.out.println("==================================");
        System.out.println("TechNova Java Server Started");
        System.out.println("http://localhost:8080");
        System.out.println("==================================");
    }
}
