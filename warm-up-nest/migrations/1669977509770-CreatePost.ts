import { identity } from 'rxjs';
import { MigrationInterface, QueryRunner, Table } from 'typeorm';

export class CreatePost1669977509770 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.createTable(
      new Table({
        name: 'post',
        columns: [
          { name: 'id', type: 'string', isPrimary: true },
          { name: 'title', type: 'string' },
          { name: 'description', type: 'string' },
          { name: 'comments', type: 'string' },
        ],
      }),
    );
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.dropTable('post');
  }
}
