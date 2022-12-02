import { BadRequestException, Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { CreatePostDto } from './dto/create-post.dto';
import { UpdatePostDto } from './dto/update-post.dto';
import { PostEntity } from './entities/post.entity';

@Injectable()
export class PostService {
  constructor(
    @InjectRepository(PostEntity) private model: Repository<PostEntity>,
  ) {}

  async create(createPostDto: CreatePostDto): Promise<PostEntity> {
    try {
      const post = this.model.create(createPostDto);
      return await this.model.save(post);
    } catch (error) {
      throw new BadRequestException('Something went wrong', {
        cause: error,
        description: error.message,
      });
    }
  }

  async findAll(): Promise<PostEntity[]> {
    return this.model.find();
  }

  async findOne(id: string): Promise<PostEntity> {
    try {
      return await this.model.findOneOrFail(id);
    } catch (error) {
      throw new BadRequestException('Cannot find entity', {
        cause: error,
        description: error.message,
      });
    }
  }

  async update(id: string, updatePostDto: UpdatePostDto): Promise<void> {
    try {
      await this.model.findOneOrFail(id);
      await this.model.update(id, updatePostDto);
    } catch (error) {
      throw new BadRequestException('Cannot find entity', {
        cause: error,
        description: error.message,
      });
    }
  }

  async remove(id: string) {
    try {
      await this.model.delete(id);
    } catch (error) {
      throw new BadRequestException('Cannot find entity', {
        cause: error,
        description: error.message,
      });
    }
  }
}
