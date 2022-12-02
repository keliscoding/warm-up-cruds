import { BeforeInsert, Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity('Post')
export class PostEntity {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column({ length: 5 })
  title: string;

  @Column({ length: 5 })
  description: string;

  @Column({ length: 5 })
  profile: string;

  @Column('simple-array')
  comments: string[];

  @BeforeInsert()
  async defaultCommentValue() {
    if (!this.comments) {
      this.comments = [];
    }
  }
}
