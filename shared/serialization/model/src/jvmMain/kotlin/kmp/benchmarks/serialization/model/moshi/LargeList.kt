package kmp.benchmarks.serialization.model.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed interface GithubPush {
    @JsonClass(generateAdapter = true)
    data class Normal(
        val id: String,
        val type: String,
        val actor: Actor,
        val repo: Repo.Simple,
        val payload: Payload,
        val public: Boolean,
        @Json(name = "created_at") val createdAt: String,
        val org: Org? = null
    ) {
        @JsonClass(generateAdapter = true)
        data class Actor(
            val id: Int,
            val login: String,
            @Json(name = "gravatar_id") val gravatarId: String,
            val url: String,
            @Json(name = "avatar_url") val avatarUrl: String
        )

        @JsonClass(generateAdapter = true)
        data class Payload(
            @Json(name = "push_id") val pushId: Int? = null,
            val size: Int? = null,
            @Json(name = "distinct_size") val distinctSize: Int? = null,
            val ref: String? = null,
            val head: String? = null,
            val before: String? = null,
            val commits: List<Commit>? = null,
            @Json(name = "ref_type") val refType: String? = null,
            @Json(name = "master_branch") val masterBranch: String? = null,
            val description: String? = null,
            @Json(name = "pusher_type") val pusherType: String? = null,
            val action: String? = null,
            val release: Release? = null,
            val number: Int? = null,
            @Json(name = "pull_request") val pullRequest: PullRequest.Full? = null,
            val issue: Issue? = null,
            val public: Boolean? = null,
            @Json(name = "created_at") val createdAt: String? = null,
            val forkee: Repo.Full? = null,
            val pages: List<Page>? = null,
            val comment: Comment? = null,
            val member: User? = null
        )

        @JsonClass(generateAdapter = true)
        data class Commit(
            val sha: String,
            val author: Author,
            val message: String,
            val distinct: Boolean,
            val url: String
        ) {
            @JsonClass(generateAdapter = true)
            data class Author(
                val email: String,
                val name: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class Release(
            val url: String,
            @Json(name = "assets_url") val assetsUrl: String,
            @Json(name = "upload_url") val uploadUrl: String,
            @Json(name = "html_url") val htmlUrl: String,
            val id: Int,
            @Json(name = "tag_name") val tagName: String,
            @Json(name = "target_commitish") val targetCommitish: String,
            val name: String? = null,
            val draft: Boolean,
            val author: User,
            val prerelease: Boolean,
            @Json(name = "created_at") val createdAt: String,
            @Json(name = "published_at") val publishedAt: String,
            val assets: List<Asset>,
            @Json(name = "tarball_url") val tarballUrl: String,
            @Json(name = "zipball_url") val zipballUrl: String,
            val body: String? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class Asset(
                val url: String,
                val id: Int,
                val name: String,
                val label: String? = null,
                val uploader: User,
                @Json(name = "content_type") val contentType: String,
                val state: String,
                val size: Int,
                @Json(name = "download_count") val downloadCount: Int,
                @Json(name = "created_at") val createdAt: String,
                @Json(name = "updated_at") val updatedAt: String,
                @Json(name = "browser_download_url") val browserDownloadUrl: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class Issue(
            val url: String,
            @Json(name = "labels_url") val labelsUrl: String,
            @Json(name = "comments_url") val commentsUrl: String,
            @Json(name = "events_url") val eventsUrl: String,
            @Json(name = "html_url") val htmlUrl: String,
            val id: Int,
            val number: Int,
            val title: String,
            val user: User,
            val labels: List<Label>,
            val state: String,
            val locked: Boolean,
            val assignee: User? = null,
            val milestone: Milestone? = null,
            val comments: Int,
            @Json(name = "created_at") val createdAt: String,
            @Json(name = "updated_at") val updatedAt: String,
            @Json(name = "closed_at") val closedAt: String? = null,
            val body: String? = null,
            @Json(name = "pull_request") val pullRequest: PullRequest.Simple? = null
        )

        @JsonClass(generateAdapter = true)
        data class Org(
            val id: Int,
            val login: String,
            @Json(name = "gravatar_id") val gravatarId: String,
            val url: String,
            @Json(name = "avatar_url") val avatarUrl: String
        )

        @JsonClass(generateAdapter = true)
        data class User(
            val login: String,
            val id: Int,
            @Json(name = "avatar_url") val avatarUrl: String,
            @Json(name = "gravatar_id") val gravatarId: String,
            val url: String,
            @Json(name = "html_url") val htmlUrl: String,
            @Json(name = "followers_url") val followersUrl: String,
            @Json(name = "following_url") val followingUrl: String,
            @Json(name = "gists_url") val gistsUrl: String,
            @Json(name = "starred_url") val starredUrl: String,
            @Json(name = "subscriptions_url") val subscriptionsUrl: String,
            @Json(name = "organizations_url") val organizationsUrl: String,
            @Json(name = "repos_url") val reposUrl: String,
            @Json(name = "events_url") val eventsUrl: String,
            @Json(name = "received_events_url") val receivedEventsUrl: String,
            val type: String,
            @Json(name = "site_admin") val siteAdmin: Boolean
        )

        sealed interface Repo {
            @JsonClass(generateAdapter = true)
            data class Simple(
                val id: Int,
                val name: String,
                val url: String
            )

            @JsonClass(generateAdapter = true)
            data class Full(
                val id: Int,
                val name: String,
                @Json(name = "full_name") val fullName: String? = null,
                val owner: User,
                val private: Boolean,
                @Json(name = "html_url") val htmlUrl: String,
                val description: String? = null,
                val fork: Boolean,
                val url: String,
                @Json(name = "forks_url") val forksUrl: String,
                @Json(name = "keys_url") val keysUrl: String,
                @Json(name = "collaborators_url") val collaboratorsUrl: String,
                @Json(name = "teams_url") val teamsUrl: String,
                @Json(name = "hooks_url") val hooksUrl: String,
                @Json(name = "issue_events_url") val issueEventsUrl: String,
                @Json(name = "events_url") val eventsUrl: String,
                @Json(name = "assignees_url") val assigneesUrl: String,
                @Json(name = "branches_url") val branchesUrl: String,
                @Json(name = "tags_url") val tagsUrl: String,
                @Json(name = "blobs_url") val blobsUrl: String,
                @Json(name = "git_tags_url") val gitTagsUrl: String,
                @Json(name = "git_refs_url") val gitRefsUrl: String,
                @Json(name = "trees_url") val treesUrl: String,
                @Json(name = "statuses_url") val statusesUrl: String,
                @Json(name = "languages_url") val languagesUrl: String,
                @Json(name = "stargazers_url") val stargazersUrl: String,
                @Json(name = "contributors_url") val contributorsUrl: String,
                @Json(name = "subscribers_url") val subscribersUrl: String,
                @Json(name = "subscription_url") val subscriptionUrl: String,
                @Json(name = "commits_url") val commitsUrl: String,
                @Json(name = "git_commits_url") val gitCommitsUrl: String,
                @Json(name = "comments_url") val commentsUrl: String,
                @Json(name = "issue_comment_url") val issueCommentUrl: String,
                @Json(name = "contents_url") val contentsUrl: String,
                @Json(name = "compare_url") val compareUrl: String,
                @Json(name = "merges_url") val mergesUrl: String,
                @Json(name = "archive_url") val archiveUrl: String,
                @Json(name = "downloads_url") val downloadsUrl: String,
                @Json(name = "issues_url") val issuesUrl: String,
                @Json(name = "pulls_url") val pullsUrl: String,
                @Json(name = "milestones_url") val milestonesUrl: String,
                @Json(name = "notifications_url") val notificationsUrl: String,
                @Json(name = "labels_url") val labelsUrl: String,
                @Json(name = "releases_url") val releasesUrl: String,
                @Json(name = "created_at") val createdAt: String,
                @Json(name = "updated_at") val updatedAt: String,
                @Json(name = "pushed_at") val pushedAt: String,
                @Json(name = "git_url") val gitUrl: String,
                @Json(name = "ssh_url") val sshUrl: String,
                @Json(name = "clone_url") val cloneUrl: String,
                @Json(name = "svn_url") val svnUrl: String,
                val homepage: String? = null,
                val size: Int,
                @Json(name = "stargazers_count") val stargazersCount: Int,
                @Json(name = "watchers_count") val watchersCount: Int,
                val language: String? = null,
                @Json(name = "has_issues") val hasIssues: Boolean,
                @Json(name = "has_downloads") val hasDownloads: Boolean,
                @Json(name = "has_wiki") val hasWiki: Boolean,
                @Json(name = "has_pages") val hasPages: Boolean,
                @Json(name = "forks_count") val forksCount: Int,
                @Json(name = "mirror_url") val mirrorUrl: String? = null,
                @Json(name = "open_issues_count") val openIssuesCount: Int,
                val forks: Int,
                @Json(name = "open_issues") val openIssues: Int,
                val watchers: Int,
                @Json(name = "default_branch") val defaultBranch: String,
                val public: Boolean? = null
            )
        }

        sealed interface PullRequest {
            @JsonClass(generateAdapter = true)
            data class Simple(
                val url: String,
                @Json(name = "html_url") val htmlUrl: String,
                @Json(name = "diff_url") val diffUrl: String,
                @Json(name = "patch_url") val patchUrl: String
            )

            @JsonClass(generateAdapter = true)
            data class Full(
                val url: String,
                val id: Int,
                @Json(name = "html_url") val htmlUrl: String,
                @Json(name = "diff_url") val diffUrl: String,
                @Json(name = "patch_url") val patchUrl: String,
                @Json(name = "issue_url") val issueUrl: String,
                val number: Int,
                val state: String,
                val locked: Boolean,
                val title: String,
                val user: User,
                val body: String? = null,
                @Json(name = "created_at") val createdAt: String,
                @Json(name = "updated_at") val updatedAt: String,
                @Json(name = "closed_at") val closedAt: String? = null,
                @Json(name = "merged_at") val mergedAt: String? = null,
                @Json(name = "merge_commit_sha") val mergeCommitSha: String? = null,
                val assignee: User? = null,
                val milestone: Milestone? = null,
                @Json(name = "commits_url") val commitsUrl: String,
                @Json(name = "review_comments_url") val reviewCommentsUrl: String,
                @Json(name = "review_comment_url") val reviewCommentUrl: String,
                @Json(name = "comments_url") val commentsUrl: String,
                @Json(name = "statuses_url") val statusesUrl: String,
                val head: Ref,
                val base: Ref,
                @Json(name = "_links") val links: Links,
                val merged: Boolean? = null,
                val mergeable: Boolean? = null,
                @Json(name = "mergeable_state") val mergeableState: String? = null,
                @Json(name = "merged_by") val mergedBy: User? = null,
                val comments: Int? = null,
                @Json(name = "review_comments") val reviewComments: Int? = null,
                val commits: Int? = null,
                val additions: Int? = null,
                val deletions: Int? = null,
                @Json(name = "changed_files") val changedFiles: Int? = null,
                val public: Boolean? = null
            ) {
                @JsonClass(generateAdapter = true)
                data class Ref(
                    val label: String,
                    val ref: String,
                    val sha: String,
                    val user: User,
                    val repo: Repo.Full? = null
                )
            }
        }

        @JsonClass(generateAdapter = true)
        data class Links(
            val self: Link,
            val html: Link,
            @Json(name = "pull_request") val pullRequest: Link? = null,
            val issue: Link? = null,
            val comments: Link? = null,
            @Json(name = "review_comments") val reviewComments: Link? = null,
            @Json(name = "review_comment") val reviewComment: Link? = null,
            val commits: Link? = null,
            val statuses: Link? = null
        ) {
            @JsonClass(generateAdapter = true)
            data class Link(
                val href: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class Label(
            val url: String,
            val name: String,
            val color: String
        )

        @JsonClass(generateAdapter = true)
        data class Page(
            @Json(name = "page_name") val pageName: String,
            val title: String,
            val summary: String? = null,
            val action: String,
            val sha: String,
            @Json(name = "html_url") val htmlUrl: String
        )

        @JsonClass(generateAdapter = true)
        data class Comment(
            val url: String,
            @Json(name = "html_url") val htmlUrl: String,
            @Json(name = "pull_request_url") val pullRequestUrl: String? = null,
            @Json(name = "_links") val links: Links? = null,
            @Json(name = "issue_url") val issueUrl: String? = null,
            val id: Int,
            @Json(name = "diff_hunk") val diffHunk: String? = null,
            val path: String? = null,
            val position: Int? = null,
            val line: Int? = null,
            @Json(name = "original_position") val originalPosition: Int? = null,
            @Json(name = "commit_id") val commitId: String? = null,
            @Json(name = "original_commit_id") val originalCommitId: String? = null,
            val user: User,
            @Json(name = "created_at") val createdAt: String,
            @Json(name = "updated_at") val updatedAt: String,
            val body: String
        )

        @JsonClass(generateAdapter = true)
        data class Milestone(
            val url: String,
            @Json(name = "labels_url") val labelsUrl: String,
            val id: Int,
            val number: Int,
            val title: String,
            val description: String? = null,
            val creator: User,
            @Json(name = "open_issues") val openIssues: Int,
            @Json(name = "closed_issues") val closedIssues: Int,
            val state: String,
            @Json(name = "created_at") val createdAt: String,
            @Json(name = "updated_at") val updatedAt: String,
            @Json(name = "due_on") val dueOn: String? = null,
            @Json(name = "closed_at") val closedAt: String? = null
        )
    }

    @JsonClass(generateAdapter = true)
    data class Compact(
        val id: String,
        val type: String,
        val actor: Actor,
        val repo: Repo,
        val payload: Payload,
        val public: Boolean,
        @Json(name = "created_at") val createdAt: String
    ) {
        @JsonClass(generateAdapter = true)
        data class Actor(
            val id: Int,
            val login: String,
            @Json(name = "gravatar_id") val gravatarId: String,
            val url: String,
            @Json(name = "avatar_url") val avatarUrl: String
        )

        @JsonClass(generateAdapter = true)
        data class Repo(
            val id: Int,
            val name: String,
            val url: String
        )

        @JsonClass(generateAdapter = true)
        data class Payload(
            @Json(name = "push_id") val pushId: Int? = null,
            val size: Int? = null,
            @Json(name = "distinct_size") val distinctSize: Int? = null,
            val ref: String? = null,
            val head: String? = null,
            val before: String? = null,
            @Json(name = "ref_type") val refType: String? = null,
            @Json(name = "master_branch") val masterBranch: String? = null,
            val description: String? = null,
            @Json(name = "pusher_type") val pusherType: String? = null
        )
    }
}