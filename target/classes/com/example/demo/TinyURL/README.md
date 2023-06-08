# TinyURL

TinyURL is a URL shortening service that is mainly used to simplify URLs, reduce their length, and make them easier to share and embed in various media. Additionally, TinyURL can also be used to hide the original URL, thus protecting the user's privacy and security.

## Implementation methods of TinyURL：

One-to-One：

- Base62 Encoding: This is an algorithm that converts any data into a string containing only 62 characters. It uses characters from 0-9, a-z, and A-Z for encoding. The Base62 algorithm can convert long URLs into short strings and can restore the original URL through reverse decoding.

  Example:

  ```cmd
  curl -X POST -d "originalUrl=example.com" http://localhost:8080/tinyurl/base62

  {"tinyUrl":"http://localhost:8080/9tGGnVevfL4sIEH","message":"success"}
  ```

  ```cmd
  curl http://localhost:8080/tinyurl/base62/9tGGnVevfL4sIEH

  {"originalUrl":"example.com","message":"success"}
  ```

- Hashing: This is one of the most commonly used implementation methods. It converts long URLs into short fixed-length strings. Hashing is a one-way function that maps input to output and cannot be reversed. Therefore, when we use hashing to convert a URL to a short string, we cannot reverse calculate the original URL from the short string. In implementation, we can use hashing algorithms such as MD5 or SHA-1 to generate fixed-length strings.

  Example:

  ```cmd
  curl -X POST -d "originalUrl=example.com" http://localhost:8080/tinyurl/hash

  {"tinyUrl":"http://localhost:8080/5ababd","message":"success"}
  ```

  ```cmd
  curl http://localhost:8080/tinyurl/hash/5ababd

  {"originalUrl":"example.com","message":"success"}
  ```

One-to-Many：

- Random Number: Another implementation method is to generate a random short string and associate it with the long URL. This method does not rely on hashing or encoding algorithms, but it requires managing a mapping table to associate each short string with its corresponding long URL.  When we need to obtain information about each user accessing an original URL, different shortened URLs can carry different information.  
    ```cmd
    curl -X POST -d "originalUrl=example.com" http://localhost:8080/tinyurl/random

    {"tinyUrl":"http://localhost:8080/qJuCwmw","message":"success"}
    ```

    ```cmd
    curl "http://localhost:8080/tinyurl/random/qJuCwmw"

    {"id":4,"shortUrl":"qJuCwmw","long_url":"example.com"}
    ```
