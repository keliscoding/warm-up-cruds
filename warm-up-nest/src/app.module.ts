import { Module } from '@nestjs/common';
import { PostModule } from './post/post.module';
import { PostEntity } from './post/entities/post.entity';
import { TypeOrmModule } from '@nestjs/typeorm';
import { SqliteConnectionOptions } from 'typeorm/driver/sqlite/SqliteConnectionOptions';

const config: SqliteConnectionOptions = {
  type: 'sqlite',
  database: '../db',
  entities: [PostEntity],
  synchronize: true,
};

@Module({
  imports: [PostModule, TypeOrmModule.forRoot(config)],
  controllers: [],
  providers: [],
})
export class AppModule {}
