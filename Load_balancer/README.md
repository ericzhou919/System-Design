# Load balancer
 
Load balancing refers to the efficient distribution of incoming network traffic across a group of backend servers. It can help with horizontal scaling as the number of servers increases.     
   
![image](https://github.com/ericzhou919/System-Design/assets/77151742/a7e197bd-cc7a-4c24-8305-70dfaa3715f7)

## Implement by Nginx and Python  
Create three Python servers with different ports and run them.   

```python
app1 = Flask(__name__)
@app1.route('/')
def server1():
    return 'This is the first server'

if __name__ == '__main__':
    app1.run(port=8080)
```
```python
app2 = Flask(__name__)
@app2.route('/')
def server2():
    return 'This is the second server'
if __name__ == '__main__':
    app2.run(port=8081)
```
```python
app3 = Flask(__name__)
@app3.route('/')
def server3():
    return 'This is the third server'
if __name__ == '__main__':
    app3.run(port=8082)
```
Edit upstream and server in your config nginx file.  
(/opt/homebrew/etc/nginx/nginx.conf)   

```nginx
 http {
        upstream uptoyou{
        server localhost:8080;
        server localhost:8081;
        server localhost:8082;
    }
    server{
        listen 80;
        server_name localhost;
        location / {
            proxy_pass http://uptoyou;
        }
    }
}
```
https://github.com/ericzhou919/System-Design/assets/77151742/500fb3c0-36be-43c4-ab5b-93c434624e78

