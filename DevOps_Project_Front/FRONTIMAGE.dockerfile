FROM node:16-alpine

WORKDIR /app

COPY package.json ./

RUN npm install

COPY . .

RUN npm run build --prod

CMD ["ng", "serve", "--prod"]
