-- liquibase formatted sql

-- changeset aaa:1
insert into machine (id, name, status) values ('machine1', 'Machine Name 1', 'in progress');
insert into machine (id, name, status) values ('machine2', 'Machine Name 2', 'not started');
insert into machine (id, name, status) values ('machine3', 'Machine Name 3', 'finished');

-- changeset aaa:2
insert into assembly (id, name, status, machine_id) values ('assembly1', 'Assembly Name 1', 'in progress', 'machine1');
insert into assembly (id, name, status, machine_id) values ('assembly2', 'Assembly Name 2', 'not started', 'machine2');

-- changeset aaa:3
insert into supplier (id, name) values ('supplier1', 'Supplier Name 1');
insert into supplier (id, name) values ('supplier2', 'Supplier Name 2');

-- changeset aaa:4
insert into material (id, name) values ('material1', 'Material Name 1');
insert into material (id, name) values ('material2', 'Material Name 2');

-- changeset aaa:5
insert into part (id, name, code_for_supplier, height, width, count, status, supplier_id, assembly_id, machine_id, material_id) values ('part1', 'Part Name 1', 'codeForSupplier1', 78, 29, 2, 'in progress', 'supplier1', 'assembly1', null, 'material1');
insert into part (id, name, code_for_supplier, height, width, count, status, supplier_id, assembly_id, machine_id, material_id) values ('part2', 'Part Name 2', 'codeForSupplier2', 45, 81, 3, 'not started', 'supplier1', null, 'machine1', 'material2');
insert into part (id, name, code_for_supplier, height, width, count, status, supplier_id, assembly_id, machine_id, material_id) values ('part3', 'Part Name 3', 'codeForSupplier3', 14, 187, 4, 'finished', 'supplier2', 'assembly2', null, 'material2');
insert into part (id, name, code_for_supplier, height, width, count, status, supplier_id, assembly_id, machine_id, material_id) values ('part4', 'Part Name 4', 'codeForSupplier4', 216, 57, 0, 'not started', 'supplier1', null, 'machine2', 'material2');