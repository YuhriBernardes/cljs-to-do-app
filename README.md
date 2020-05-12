# Clojurescript To Do app

A simple `to do` application with clojurescript. There is no backend.

<p align="center">
  <img alt="App Demo" src="https://raw.githubusercontent.com/YuhriBernardes/cljs-to-do-app/master/doc/app.gif">
</p>

# Dependencies

- Java 8+
- Clojure 1.10.0+
- NodeJS 10+

# Libs

- Shadow CLJS
- Reagent (clojurescript lib for React development)

# Run the app

### Locally

```shell
npx shadow-cljs watch app
```

### On docker

Docker 19.03.8-ce (or newer) is required.

- **Build the image**
```shell
docker build \
    -t cljs-todo \
    -f ./.setup/Dockerfile .
```

- **Run a new Container**

```shell
docker run -d
```
