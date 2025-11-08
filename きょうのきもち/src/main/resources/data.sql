INSERT into diaries (account_id, date, feeling, text)
values
(1, '2025/10/01', 1, ''),
(1, '2025/10/02', 4, ''),
(1, '2025/10/03', 3, ''),
(1, '2025/11/02', 4, ''),
(1, '2025/11/07', 5, '元気'),
(1, '2025/12/04', 2, '');


INSERT into medicines (name, effect)
values
('バファリン', '頭痛に効く'),
('正露丸', '胃腸に効く'),
('命の母', '更年期に効く');

INSERT into takings (account_id, time)
values
(1, '2025-11-06 16:11:18.791'),
(1, '2025-11-07 20:11:18.791'),
(2, '2025-11-07 17:11:18.791');

INSERT into medicine_taking (medicine_id, taking_id)
values
(1, 1),
(2, 1),
(2, 2);

INSERT into groups (account_id, name, code)
values
(1, 'グループ1', 1234),
(1, 'グループ2', 5678),
(1, 'グループ3', 9012),
(1, 'グループ4', 3456),
(1, 'グループ5', 7890);

INSERT into diseases (name)
values
('うつ'),
('そううつ'),
('よくうつ');

INSERT into accounts (nickname, attribute, group_id, follow_id)
values
('たかし', true, null, null),
('たかだ', false, 1, 1),
('ほんごう', false, 1, 1),
('もりかわ', false, 2, 1),
('おおがみ', false, 2, 1);

INSERT INTO diseases (name) VALUES
('うつ病'),
('てんかん'),
('パニック障害'),
('強迫性障害'),
('自閉スペクトラム症（ASD）'),
('心的外傷後ストレス障害（PTSD）'),
('睡眠障害'),
('摂食障害'),
('双極性障害Ⅰ型'),
('双極性障害Ⅱ型'),
('注意欠如・多動症（ADHD）'),
('適応障害'),
('統合失調症');

INSERT INTO scopes
VALUES
(5, 1, true),
(5, 2, true),
(5, 3, true),
(5, 4, false),
(5, 5, false);

INSERT INTO reactions (account_id, diary_id, stamp, comment)
VALUES
(2, 7, 1, 'おはよう'),
(3, 7, 2, '元気？');