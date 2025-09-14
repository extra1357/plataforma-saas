// src/server.ts
import 'zone.js/node';
import express from 'express';
import { join } from 'path';
import { existsSync } from 'fs';

import bootstrap from './main.server';

const server = express();
const distFolder = join(process.cwd(), 'dist/front-end/browser');
const indexHtml = existsSync(join(distFolder, 'index.html'))
  ? 'index.html'
  : 'index.original.html';

// 1. Arquivos estáticos (CSS, JS, imagens, etc.)
server.use(express.static(distFolder, { maxAge: '1y' }));

// 2. Rota raiz (opcional, mas ajuda em casos específicos)
server.get('/', async (req, res, next) => {
  try {
    await bootstrap();
    res.sendFile(join(distFolder, indexHtml));
  } catch (err: any) {
    next(err);
  }
});

// 3. Catch-all seguro para Express 5 (usa RegExp em vez de '*')
server.get(/.*/, async (req, res, next) => {
  try {
    await bootstrap();
    res.sendFile(join(distFolder, indexHtml));
  } catch (err: any) {
    next(err);
  }
});

// 4. Porta do servidor (corrigido TS4111)
const port = Number(process.env['PORT'] || 4000);

// 5. Inicia o servidor
server.listen(port, () => {
  console.log(`✅ Node server listening on http://localhost:${port}`);
});
