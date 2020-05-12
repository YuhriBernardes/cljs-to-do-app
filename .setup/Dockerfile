FROM theasp/clojurescript-nodejs:shadow-cljs-alpine as build

WORKDIR /app

COPY ./src ./src
COPY ./app ./app
COPY ./shadow-cljs.edn ./
COPY ./package.json ./

RUN npm i -g npm

RUN npm install
RUN shadow-cljs release app

FROM nginx:alpine as runtime

WORKDIR /app

RUN rm -rf /etc/nginx/conf.d/*

# Copy your nginx config to /etc/nginx/conf.d
COPY ./.setup/nginx.conf /etc/nginx/conf.d

COPY --from=build /app/app/ /usr/share/app
