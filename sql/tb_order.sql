create table tb_order
(
    id          bigint auto_increment
        primary key,
    create_time datetime       default CURRENT_TIMESTAMP null,
    update_time datetime       default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    uid         bigint                                   not null comment '用户ID',
    content_id  bigint                                   not null comment '商品内容ID',
    amount      decimal(10, 2) default 0.00              null comment '金额',
    status      tinyint(1)     default 0                 null comment '订单支付状态：0->创建;1-成功>;2->失败',
    remark      varchar(50)                              null comment '备注'
);

create index index_coment_id
    on tb_order (content_id);

create index index_uid
    on tb_order (uid);

